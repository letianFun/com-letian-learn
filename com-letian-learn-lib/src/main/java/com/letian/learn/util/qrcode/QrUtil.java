package com.letian.learn.util.qrcode;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.letian.learn.util.qrcode.dto.QrDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QrUtil {
    private static Logger logger = LoggerFactory.getLogger(QrUtil.class);

//    /**
//     * @param args
//     * @throws IOException
//     * @throws WriterException
//     */
//    public static void main(String[] args) throws WriterException, IOException {
//        String filePath = "D://temp//qr//";
//        String fileName = "zxing1.png";
//        JSONObject json = new JSONObject();
//        json.put("zxing", "https://github.com/zxing/zxing/tree/zxing-3.0.0/javase/src/main/java/com/google/zxing");
//        json.put("author", "shihy");
//        String content = json.toJSONString();// 内容
//        content = "http://www.sssyin.cn/online/pay/?id=952010565811";
//        int width = 200; // 图像宽度
//        int height = 200; // 图像高度
//        String format = "png";// 图像类型
//        QrDTO qrDTO = new QrDTO();
//        qrDTO.setFileName(fileName);
//        qrDTO.setContent(content);
//        qrDTO.setFilePath(filePath);
//        qrDTO.setHeight(height);
//        qrDTO.setFormat(format);
//        qrDTO.setWidth(width);
//        createImage(qrDTO);
//        String contentResult = analysisImage(filePath + fileName);
//        JSONObject contentJson = JSONObject.parseObject(contentResult);
//        logger.info("图片中内容：  ");
//        logger.info("author： " + contentJson.getString("author"));
//        logger.info("zxing：  " + contentJson.getString("zxing"));
//        logger.info("图片中格式：  ");
//        //logger.info("encode： " + result.getBarcodeFormat());
//    }

    /**
     * 生成图像
     *
     * @throws WriterException
     * @throws IOException
     */
    public static void createImage(QrDTO qrDTO) throws WriterException, IOException {
        String filePath = qrDTO.getFilePath();
        String fileName = qrDTO.getFileName();
        String content = qrDTO.getContent();
        int width = qrDTO.getWidth();
        int height = qrDTO.getHeight();
        String format = qrDTO.getFormat();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);
    }

    /**
     * 解析图像
     */
    public static String analysisImage(String filePath) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(filePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            // 对图像进行解码
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);
            return result.getText();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
