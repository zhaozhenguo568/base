package cn.cisdom.base.api;

import cn.cisdom.base.annotation.LoginUser;
import cn.cisdom.base.entity.UserEntity;
import cn.cisdom.base.utils.ConfigConstant;
import cn.cisdom.base.utils.DateUtils;
import cn.cisdom.base.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * 上传文件
 *
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-18 16:04:48
 */
@Api(description = "上传文件相关的接口")
@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @RequestMapping(value = "logo", consumes = "multipart/form-data", method = RequestMethod.POST)
    @ApiOperation(notes = "上传logo", value = "上传logo", httpMethod = "POST")
    public R logo(@LoginUser UserEntity user, MultipartHttpServletRequest request) {

        final String type = "img/" + user.getId() + "/logo/";
        final String dateStr = DateUtils.format(new Date(), DateUtils.DATE_PATTERN);
        String path = ConfigConstant.BASE_FILE_PATH + type + dateStr + "/";

        try {
            CommonsMultipartFile item = (CommonsMultipartFile) request.getFiles("file").get(0);

            if (item == null) {
                return R.error("上传出错,请重试尝试");
            }
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            path += item.getOriginalFilename();
            final int ext = path.lastIndexOf('.');
            final int name = path.lastIndexOf('/');
            String fileName = path.substring(name + 1, ext);
            String newPath = path.replace(fileName, String.valueOf(System.currentTimeMillis()));
            System.out.println(fileName);
            System.out.println(newPath);
            File localFile = new File(newPath);
            try {
                item.transferTo(localFile);

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                return R.error(e.getMessage());
            }

            Map<String, Object> result = new HashedMap();
            result.put("data", type + dateStr + "/" + localFile.getName());

            return R.ok(result);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }


}
