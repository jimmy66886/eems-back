package com.zzmr.eemsback.controller;

import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.result.Result;
import com.zzmr.eemsback.service.UserService;
import io.swagger.annotations.Api;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzmr
 * @create 2024-01-05 19:13
 */
@RestController
@Api(tags = "上传文件相关接口")
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {

    @Autowired
    private UserService userService;

    @PostMapping("/excel")
    public Result handleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println("测试");
        try {

            if (file.isEmpty()) {
                return Result.error("请选择一个文件！");
            }

            List<User> users = readExcel(file.getInputStream());
            userService.saveBatch(users);


            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("上传失败");
        }
    }

    private List<User> readExcel(InputStream inputStream) throws IOException {
        Workbook workbook = WorkbookFactory.create(inputStream);

        List<User> users = new ArrayList<>();


        Sheet sheet = workbook.getSheetAt(0);


        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            // 转换为字符类型
            for (Cell cell : row) {
                cell.setCellType(CellType.STRING);
            }

            String account = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            String birthday = row.getCell(2).getStringCellValue();
            String name = row.getCell(3).getStringCellValue();
            String ic = row.getCell(4).getStringCellValue();
            String classId = row.getCell(5).getStringCellValue();

            User user =
                    User.builder().account(account).password(password)
                            .birthday(LocalDate.parse(birthday)).name(name)
                            .ic(ic).classId(Integer.parseInt(classId)).type(0)
                            .build();
            users.add(user);
        }

        workbook.close();
        return users;
    }


    private List<User> readExcelTeacher(InputStream inputStream) throws IOException {
        Workbook workbook = WorkbookFactory.create(inputStream);

        List<User> users = new ArrayList<>();


        Sheet sheet = workbook.getSheetAt(0);


        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            // 转换为字符类型
            for (Cell cell : row) {
                cell.setCellType(CellType.STRING);
            }

            String account = row.getCell(0).getStringCellValue();
            String name = row.getCell(1).getStringCellValue();
            String classId = row.getCell(2).getStringCellValue();

            User user =
                    User.builder().account(account).password("000000")
                            .name(name).classId(Integer.parseInt(classId)).type(1)
                            .build();
            users.add(user);
        }

        workbook.close();
        return users;
    }

    @PostMapping("/excel/teacher")
    public Result handleTeacherFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println("测试");
        try {

            if (file.isEmpty()) {
                return Result.error("请选择一个文件！");
            }

            List<User> users = readExcelTeacher(file.getInputStream());
            userService.saveBatch(users);


            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("上传失败");
        }
    }


    @GetMapping("/downloadTemplate")
    public ResponseEntity<Resource> downloadTemplate() {
        // 下载模板逻辑
        // 这里假设模板文件是在类路径下的templates目录中的excel_template.xlsx
        Resource resource = new ClassPathResource("template/students.xlsx");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping("/downloadTemplateTeacher")
    public ResponseEntity<Resource> downloadTemplateTeacher() {
        // 下载模板逻辑
        // 这里假设模板文件是在类路径下的templates目录中的excel_template.xlsx
        Resource resource = new ClassPathResource("template/teachers.xlsx");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

}
