package com.example.activitidemo.controller;


import com.example.activitidemo.config.annotation.Log;
import com.example.activitidemo.dao.UsersRepository;
import com.example.activitidemo.entity.dto.UsersDTO;
import com.example.activitidemo.entity.po.Users;
import com.example.activitidemo.utils.returnMode.ResultModel;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Indexed
@RestController
@RequestMapping("/usersController")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @ResponseBody
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @Log(operationType = "add操作:", operationName = "添加用户")
    public ResultModel<String> testAOP(@RequestBody @Validated UsersDTO usersDTO){
        ResultModel<String> resultModel = new ResultModel<>();
//        if(bindingResult.hasErrors()){
//            List<ObjectError> errors = bindingResult.getAllErrors();
//            List<String> strings = errors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
//            errors.stream().forEach(it -> {
//                System.out.println(it.getDefaultMessage());
//
//
//            });
//            resultModel.fail(strings.toString());
//            return resultModel;
//        }
        Users users = new Users();
        BeanUtils.copyProperties(usersDTO,users);
        Users users1 = usersRepository.save(users);
        resultModel.setMessage("新增成功,Id为：" + users1.getId());
        return resultModel;
    }

    @GetMapping("/download")
    public ResultModel<String> download(HttpServletResponse response){
        String f = "平台通用隐私协议模板.docx";
        //        TermsContentVO termsContentVO = this.execute(orgCode, serviceFlag);
//        String content = termsContentVO.getContent();
        String s = "/doc/".concat(f);
        String basePath = getResourceBasePath();
        String path = basePath.concat(s).replace("\\", "\\\\").replace("/", "\\\\");
        String content = readByExtractor(path);
//        String content = readByExtractor(basePath.concat(s).replace("\\", "/"));
        this.getData(content,path);
        File file = new File(path);
        String fileName = file.getName();
        //设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
        try {
            response.setHeader("Content-Disposition", "attachment;fileName=" +
                    new String(fileName.getBytes("utf-8"), "ISO-8859-1"));
        } catch (
                UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            byte[] b = new byte[bis.available() + 1000];
            int i = 0;
            os = response.getOutputStream();  //直接下载导出
            while ((i = bis.read(b)) != -1) {
                os.write(b, 0, i);
            }
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }



    /**
     * 获取项目根路径
     *
     * @return
     */
    private static String getResourceBasePath() {
        // 获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String pathStr = path.getAbsolutePath();
        return pathStr;
    }

    public void getData(String content,String s) {
        //新建一个文档
        XWPFDocument doc = new XWPFDocument();
        //创建一个段落
        XWPFParagraph para = doc.createParagraph();

        //一个XWPFRun代表具有相同属性的一个区域。
        XWPFRun run = para.createRun();
        run.setBold(true); //加粗
        run = para.createRun();
        //run.setColor("FF0000");
        //设置内容
        run.setText(content);
        OutputStream os = null;
        try {
            os = new FileOutputStream(s);
            doc.write(os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //把doc输出到输出流
        this.close(os);
    }

    /**
     * 通过XWPFWordExtractor访问XWPFDocument的内容
     * @throws Exception
     */
    public String readByExtractor(String path) {
        String buffer = "";
        try {
//            if (path.endsWith(".doc")) {
//                InputStream is = new FileInputStream(new File(path));
//
//                WordExtractor ex = new WordExtractor(is);
//                buffer = ex.getText();
//                ex.close();
//            } else if (path.endsWith("docx")) {
//                File file = new File(path);
//                String fileName = file.getName();
//                OPCPackage opcPackage = POIXMLDocument.openPackage(fileName);
//                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
//                buffer = extractor.getText();
//                extractor.close();
//            }
            FileInputStream fis = new FileInputStream(path);
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            buffer = extractor.getText();
            this.close(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;

    }

    /**
     * 关闭输入流
     * @param is
     */
    private void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     * @param os
     */
    private void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
