package com.android.monkeyrunner.recorder;


import java.io.ByteArrayOutputStream;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;

import java.lang.reflect.Method;

import java.util.List;

 

//import org.apache.commons.logging.Log;
//
//import org.apache.commons.logging.LogFactory;
//
// 
//
//import com.hzqy.web.commons.utils.AreaNameUtil;
//
//import com.hzqy.web.music.stat.dao.StatDao;
//
//import com.hzqy.web.music.stat.refutil.GetValueByRef;
//
//import com.hzqy.web.music.stat.vo.DataExperenceVo;

 

import jxl.Workbook;

import jxl.WorkbookSettings;

import jxl.read.biff.BiffException;

import jxl.write.Label;

import jxl.write.WritableCell;

import jxl.write.WritableCellFormat;

import jxl.write.WritableFont;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;

import jxl.write.WriteException;

import jxl.write.biff.RowsExceededException;

 

public class JXLUtil {

//    private static final Log LOG = LogFactory.getLog(JXLUtil.class);

    public static WritableFont arial14font = null;

 

    public static WritableCellFormat arial14format = null;

    public static WritableFont arial10font = null;

    public static WritableCellFormat arial10format = null;

    public static WritableFont arial12font = null;

    public static WritableCellFormat arial12format = null;

 

    public final static String UTF8_ENCODING = "UTF-8";

    public final static String GBK_ENCODING = "GBK";

 

    public static int index = 1;// д�����

    public static int row = 2;// �����ֶ�д��ӵڶ��п�ʼ

 

    /**

     * ��ʽ����

     */

    public static void format() {

        try {

            arial14font = new WritableFont(WritableFont.ARIAL, 14,

                    WritableFont.BOLD);

            arial14font.setColour(jxl.format.Colour.LIGHT_BLUE);

            arial14format = new WritableCellFormat(arial14font);

            arial14format.setAlignment(jxl.format.Alignment.CENTRE);

            arial14format.setBorder(jxl.format.Border.ALL,

                    jxl.format.BorderLineStyle.THIN);

            arial14format.setBackground(jxl.format.Colour.VERY_LIGHT_YELLOW);

            arial10font = new WritableFont(WritableFont.ARIAL, 10,

                    WritableFont.BOLD);

            arial10format = new WritableCellFormat(arial10font);

            arial10format.setAlignment(jxl.format.Alignment.CENTRE);

            arial10format.setBorder(jxl.format.Border.ALL,

                    jxl.format.BorderLineStyle.THIN);

            arial10format.setBackground(jxl.format.Colour.LIGHT_BLUE);

            arial12font = new WritableFont(WritableFont.ARIAL, 12);

            arial12format = new WritableCellFormat(arial12font);

            arial12format.setBorder(jxl.format.Border.ALL,

                    jxl.format.BorderLineStyle.THIN);

        } catch (WriteException e) {

//            LOG.debug("��ʽ���ô���");

            e.printStackTrace();

        }

    }

 

    public static void initExcel(String fileName, String[] colName,

            int[] widthArr) {

        JXLUtil.index = 0;// ����Ϊ��ʼֵ����Ȼstatic��index��һֱ����

        JXLUtil.row = 2;

        format();// �����ø�ʽ

        WritableWorkbook workbook = null;

        try {

            // WorkbookSettings setEncode = new WorkbookSettings(); // ���ö��ļ�����

            // setEncode.setEncoding(UTF8_ENCODING);

            File file = new File(fileName);

            workbook = Workbook.createWorkbook(file);

  //          LOG.debug("�������������ɹ�");

            WritableSheet sheet = workbook.createSheet("Sheet 1", 0);// ����sheet

            sheet.mergeCells(0, 0, colName.length - 1, 0);

            sheet.addCell((WritableCell) new Label(0, 0, fileName,

                    arial14format));// ��ͷ�������

            for (int i = 0; i < widthArr.length; i++) {

                sheet.setColumnView(i, widthArr[i]);// ����col ���

            }

 

            int row = 1;

            int col = 0;

            for (col = 0; col < colName.length; col++) {

                sheet.addCell(new Label(col, row, colName[col], arial10format));// д��

                                                                                // col����

            }

            workbook.write();// д������

  //          LOG.debug("init ok!");

        } catch (RowsExceededException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } catch (WriteException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } finally {

            if (workbook != null) {

                try {

                    workbook.close();

                } catch (WriteException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                } catch (IOException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                }

            }

        }
    }
 
    
    /**

     * �� ����д�뵽excel��

     *

     * @param os

     *            ����Excel�������

     * @param objList

     *            Ҫ���������

     * @param fieldArr

     *            �ֶ�����

     * @param fileName

     *            excel��ͷ����

     * @param colName

     *            excel����

     * @param widthArr

     *            excel��Ԫ����

     */

    public static <T> void dataToExcel(ByteArrayOutputStream os,

            List<T> objList, String[] fieldArr, String fileName,

            String[] colName, int[] widthArr) {

        format();// �����ø�ʽ

        WritableWorkbook workbook = null;

        try {

            // WorkbookSettings setEncode = new WorkbookSettings(); // ���ö��ļ�����

            // setEncode.setEncoding(UTF8_ENCODING);

            // File file = new File(fileName);

            workbook = Workbook.createWorkbook(os);

    

            WritableSheet sheet = workbook.createSheet("Sheet 1", 0);// ����sheet

            sheet.mergeCells(0, 0, colName.length - 1, 0);

            sheet.addCell((WritableCell) new Label(0, 0, fileName,

                    arial14format));// ��ͷ�������

            for (int i = 0; i < widthArr.length; i++) {

                sheet.setColumnView(i, widthArr[i]);// ����col ���

            }

 

            int row = 1;

            int col = 0;

            for (col = 0; col < colName.length; col++) {// д������

                sheet.addCell(new Label(col, row, colName[col], arial10format));// д��

                                                                                // col����

            }

 

            for (Object tmp : objList) {// д������

                row++;

                col = 0;

                index++;

                String serialNumberStr = String.valueOf(index);

                sheet.addCell(new Label(col, row, serialNumberStr,

                        arial12format));// ��һ������д���

                col++;

                /**

                 * ͨ������ȡֵ������д�뵽excel��

                 */

                for (int i = 0; i < fieldArr.length; i++) {

                    String fieldName = fieldArr[i];

                    Object value = GetValueByRef.getValueByRef(tmp, fieldName);

                    String str = null;

                    if (value == null) {

                        str = "";

                    } else {

                        str = String.valueOf(value);

                    }

                    sheet.addCell(new Label(col, row, str, arial12format));

                    col++;

                }

            }

            workbook.write();// д������



        } catch (RowsExceededException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } catch (WriteException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } finally {

            if (workbook != null) {

                try {

                    workbook.close();

                } catch (WriteException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                } catch (IOException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                }

            }

            if (os != null) {

                try {

                    os.close();

                } catch (IOException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                }

            }

        }

    }

 

    public static <T> void writeObjListToExcel(List<T> objList,

            String fileName, String[] fieldArr) {

        if (objList != null && objList.size() > 0) {

            WritableWorkbook writebook = null;

            InputStream in = null;

            try {

                /**

                 * ��ȡԭ��д����ļ�

                 */

                // WorkbookSettings setEncode = new WorkbookSettings();

                // //���ö��ļ�����

                // setEncode.setEncoding(UTF8_ENCODING);

                in = new FileInputStream(new File(fileName));

                Workbook workbook = Workbook.getWorkbook(in);

                writebook = Workbook.createWorkbook(new File(fileName),

                        workbook);

                WritableSheet sheet = writebook.getSheet(0);

                /**

                 * д������

                 */

                // {"���","���鿨��","�ֻ�����","�û�iTV�ʺ�","����","ʹ��ʱ��","���鵽��ʱ��","�������Ƿ񶩹�"};

 

                for (Object tmp : objList) {

                    Class classType = tmp.getClass();

                    int col = 0;

                    index++;

                    String serialNumberStr = String.valueOf(index);

                    sheet.addCell(new Label(col, row, serialNumberStr,

                            arial12format));// ��һ������д���

                    col++;

                    /**

                     * ͨ������ȡֵ������д�뵽excel��

                     */

                    for (int i = 0; i < fieldArr.length; i++) {

                        String fieldName = fieldArr[i];

                        Object value = GetValueByRef.getValueByRef(tmp,

                                fieldName);

                        String str = null;

                        if (value == null) {

                            str = "";

                        } else {

                            str = String.valueOf(value);

                        }

                        sheet.addCell(new Label(col, row, str, arial12format));

                        col++;

                    }

                    row++;

                }

                writebook.write();

          

            } catch (BiffException e) {

                e.printStackTrace();

            } catch (WriteException e) {
;

                e.printStackTrace();

            } catch (IOException e) {


            } finally {

                if (writebook != null) {

                    try {

                        writebook.close();

                    } catch (WriteException e) {


                        e.printStackTrace();

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

               }if(in != null){

                    try {

                        in.close();

                    } catch (IOException e) {



                        e.printStackTrace();

                    }

                }

            }

 

        }

    }

 

}

 
