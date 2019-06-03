package com.nico.student.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

import javax.imageio.ImageIO;

import com.nico.student.bean.File;
import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFTextParagraph;
import org.apache.poi.hslf.usermodel.HSLFTextRun;


public class ToImageUtil {

    public static Integer converPPTtoImage(File file) throws IOException {
        java.io.File f = new java.io.File(PathUtils.PPT_PATH+file.getData());
        InputStream pptStream = new FileInputStream(f);

        java.io.File file1 = new java.io.File(PathUtils.IMAGE_PATH+file.getPrefix());
        if(file1.exists()) {
            int len = file1.list().length;
            return len;
        }else{
            file1.mkdir();
            try (HSLFSlideShow oneSlideShow = new HSLFSlideShow(pptStream)) {
                List<HSLFSlide> pptPageXSLFSLiseList = oneSlideShow.getSlides();
                for (int i = 0; i < pptPageXSLFSLiseList.size(); i++) {
                    for (List<HSLFTextParagraph> list : pptPageXSLFSLiseList.get(i).getTextParagraphs()) {
                        for (HSLFTextParagraph hslfTextParagraph : list) {
                            for (HSLFTextRun textRun : hslfTextParagraph.getTextRuns()) {
                                Double size = textRun.getFontSize();
                                if ((size <= 0) || (size >= 26040)) {
                                    textRun.setFontSize(20.0);
                                }
                                textRun.setFontFamily("simsun");
                            }
                        }
                    }
                    String imgName =  (i + 1) + ".png";
                    BufferedImage oneBufferedImage = new BufferedImage(oneSlideShow.getPageSize().width, oneSlideShow.getPageSize().height, BufferedImage.TYPE_INT_RGB);
                    Graphics2D oneGraphics2D = oneBufferedImage.createGraphics();
                    pptPageXSLFSLiseList.get(i).draw(oneGraphics2D);
                    try( OutputStream imageOut = new FileOutputStream(PathUtils.IMAGE_PATH+file.getPrefix()+"/"+imgName)) {
                        ImageIO.write(oneBufferedImage, "png", imageOut);
                    } finally { }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            java.io.File file2 = new java.io.File(PathUtils.IMAGE_PATH+file.getPrefix());
            return file2.list().length;
        }
    }




}
