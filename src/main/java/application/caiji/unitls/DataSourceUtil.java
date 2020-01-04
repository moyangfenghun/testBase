package application.caiji.unitls; 
import java.io.InputStream;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
/*
 * 调用阿里巴巴连接池工具druid
 * */
public class DataSourceUtil {
	//链接tiku数据库改为链接v3数据库
    private static DruidDataSource dds_mysql = null;
    private static DruidDataSource dds_mysql_weixin_mp = null;
    private static DruidDataSource dds_mysql_chatlog = null;//聊天室记录
    private static DruidDataSource dds_mysql_studylog = null;//学习日志记录
    private static DruidDataSource dds_mysql_weixinfenxiang = null;//学习日志记录
    private static DruidDataSource dds_mysql_mc = null;//mc
    private static DruidDataSource dds_mysql_pintuan = null;//mc
    private static DruidDataSource dds_mssql_oaandcrm = null; //crm数据库
    private static DruidDataSource dds_mssql_customerbusiness = null;//客户交易数据库
    private static DruidDataSource dds_mssql_examsys = null;//题库正式环境数据库
    private static DruidDataSource dds_mssql_examtiku = null;//题库编辑环境数据库
    private static DruidDataSource dds_mssql_ebook = null;
    private static DruidDataSource dds_oracle = null;
    private static DruidDataSource dds_mysql_orderanalysis = null;//订单分析库
    private static DruidDataSource dds_mysql_learninganalysis = null;//学情分析库
    private static DruidDataSource dds_mysql_tuiguang = null;//推广系统库
    private static DruidDataSource dds_mysql_app_tuiguang = null;//app推广系统库
    private static DruidDataSource dds_mysql_ytk = null;//ytk
    private static DruidDataSource dds_mysql_promotiondata = null;//第三方推广
    private static DruidDataSource dds_mysql_dianjing360 = null;//360推广数据
    private static DruidDataSource dds_mysql_question_article = null;//文章
    private static DruidDataSource dds_mysql_bkw_data = null;//资讯站
    private static DruidDataSource dds_mysql_bkw_question_recommend=null;
    private static DruidDataSource dds_mysql_local_testdate=null;

    static{
        try {
            InputStream in16 = DataSourceUtil.class.getClassLoader().getResourceAsStream("mysql/bkw_tuiguang.properties");
            Properties p16 = new Properties();
            p16.load(in16);
            dds_mysql_tuiguang = (DruidDataSource) DruidDataSourceFactory
                    .createDataSource(p16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream in16 = DataSourceUtil.class.getClassLoader().getResourceAsStream("mysql/my_testdate.properties");
            Properties p16 = new Properties();
            p16.load(in16);
            dds_mysql_local_testdate = (DruidDataSource) DruidDataSourceFactory
                    .createDataSource(p16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static DruidDataSource getDruidDataSource(String type) {
    	if(type.equals("mysql")){
	        return dds_mysql;
    	}else if(type.equals("weixin_mp")){
	        return dds_mysql_weixin_mp;
    	}else if(type.equals("weixinfenxiang")){
	        return dds_mysql_weixinfenxiang;
    	}else if(type.equals("mc")){
	        return dds_mysql_mc;
    	}else if(type.equals("pintuan")){
	        return dds_mysql_pintuan;
    	}else if(type.equals("orderanalysis")){
	        return dds_mysql_orderanalysis;
    	}else if(type.equals("learninganalysis")){
	        return dds_mysql_learninganalysis;
    	}else if(type.equals("chatlog")){
	        return dds_mysql_chatlog;
    	}else if(type.equals("studylog")){
	        return dds_mysql_studylog;
    	}else if(type.equals("oaandcrm")){
            return dds_mssql_oaandcrm; 
		}else if(type.equals("examsys")){
	        return dds_mssql_examsys; 
		}else if(type.equals("customerbusiness")){
		    return dds_mssql_customerbusiness;    		
		}else if(type.equals("examtiku")){
		    return dds_mssql_examsys;    		
		}else if(type.equals("ebook")){
		    return dds_mssql_ebook;    		
		}else if(type.equals("oracle")){
		    return dds_oracle;    		
		}else if(type.equals("thuiguang")){
		    return dds_mysql_tuiguang;    		
		}else if(type.equals("appthuiguang")){
		    return dds_mysql_app_tuiguang;    		
		}else if(type.equals("yitiku")){
		    return dds_mysql_ytk;    		
		}else if(type.equals("promotiondata")){
		    return dds_mysql_promotiondata;    		
		}else if(type.equals("dianjing360")){
            return dds_mysql_dianjing360;
        }else if(type.equals("bkw_question_article")){
            return dds_mysql_question_article;
        }else if(type.equals("bkw_data")){
            return dds_mysql_bkw_data;
        }else if(type.equals("bkw_question_recommend")){
            return dds_mysql_bkw_question_recommend;
        }else if(type.equals("my_testdate")){
            return dds_mysql_local_testdate;
        }
    	return null;
    }

	
	
}
