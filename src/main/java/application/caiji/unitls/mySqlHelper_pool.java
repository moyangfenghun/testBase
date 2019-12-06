package application.caiji.unitls;   
  
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.RowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 
 * mysql 数据操作帮助类
 * 
 * **/
public class mySqlHelper_pool {  
    // 定义要使用的变量      
	public static final String Conn_oa = "mysql";
	public static final String Conn_weixin_mp = "weixin_mp";
	public static final String Conn_chatlog = "chatlog";
	public static final String Conn_studylog = "studylog";
	public static final String Conn_mc = "mc";
	public static final String Conn_pintuan = "pintuan";
	public static final String Conn_weixinfenxiang = "weixinfenxiang";
	public static final String Conn_orderanalysis = "orderanalysis";
	public static final String Conn_learninganalysis = "learninganalysis";
	public static final String Conn_thuiguang = "thuiguang";
	public static final String Conn_APP_thuiguang = "appthuiguang";
	public static final String Conn_ytk = "yitiku";
	public static final String Conn_promotiondata = "promotiondata";
	public static final String Conn_dianjing360 = "dianjing360";
	public static final String Conn_question_article = "bkw_question_article";
	public static final String Conn_bkw_data = "bkw_data";
	public static final String Conn_bkw_question_recommend = "bkw_question_recommend";
    // 得到连接
    public static Connection getConnection(String connstr) throws Exception { 
    	Connection conn = null;  
        try { 
        	conn = DataSourceUtil.getDruidDataSource(connstr).getConnection();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return conn;  
    }  
  
    // 处理多个update/delete/insert  
    public static void executeUpdateMultiParams(String connstr,String[] sql,  
            String[][] parameters) {
		Connection conn = null;  
        PreparedStatement ps = null;  
        ResultSet rs = null;   
        try {  
        	
            // 获得连接  
            conn = getConnection(connstr);  
            // 可能传多条sql语句  
            conn.setAutoCommit(false);  
            for (int i = 0; i < sql.length; i++) {  
                if (parameters[i] != null) {  
                    ps = conn.prepareStatement(sql[i]);  
                    for (int j = 0; j < parameters[i].length; j++)  
                        ps.setString(j + 1, parameters[i][j]);  
                }  
                ps.executeUpdate();  
            }  
            conn.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
            try {  
                conn.rollback();  
            } catch (SQLException e1) {  
                e1.printStackTrace();  
            }  
            throw new RuntimeException(e.getMessage());  
        } finally {  
            // 关闭资源  
            close(rs, ps, conn);  
        }  
    }  
  
    // update/delete/insert  
    // sql格式:UPDATE tablename SET columnn = ? WHERE column = ?  
    public static void executeUpdate(String connstr,String sql, String[] parameters) {
    	Connection conn = null;  
        PreparedStatement ps = null;  
        ResultSet rs = null;  
        CallableStatement cs = null; 
        try {  
            // 1.创建一个ps  
            conn = getConnection(connstr);  
            ps = conn.prepareStatement(sql);  
            // 给？赋值  
            if (parameters != null)  
                for (int i = 0; i < parameters.length; i++) {  
                    ps.setString(i + 1, parameters[i]);  
                }  
            // 执行  
            ps.executeUpdate();  
        } catch (SQLException e) {
            close(rs, cs, conn);    
            e.printStackTrace();// 开发阶段  
            throw new RuntimeException(e.getMessage());  
        } catch (Exception e) {
            close(rs, cs, conn);  
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {  
            // 关闭资源  
            close(rs, ps, conn);  
        }  
    }  

    // insert  
    //批量导入数据
    public static void executeUpdate_batchinsert(String connstr,String sql, List<String[]> parameters) {
    	Connection conn = null;  
        PreparedStatement ps = null;  
        ResultSet rs = null;  
        CallableStatement cs = null; 
        try {  
            // 1.创建一个ps  
            conn = getConnection(connstr); 
            conn.setAutoCommit(false);  
            ps = conn.prepareStatement(sql);  
            // 给？赋值  
            int sum = 0;
            int[] num = null;
            for (int i=0;i<parameters.size();i++)
            {
            	String[] para = parameters.get(i);
            	for (int c = 0; c < para.length; c++) {  
                    ps.setString(c + 1, para[c]);  
                } 
                ps.addBatch();
                if(i !=0 && i%3000==0){
                	num = ps.executeBatch();
                	sum +=num.length;
                	conn.commit();
                	//System.out.println("批量更新成功："+sum+ "条记录！");
                }
            } 
            num = ps.executeBatch();
        	sum +=num.length;
        	conn.commit();
        	conn.setAutoCommit(true);
        	//System.out.println("--批量更新成功："+sum+ "条记录！");
            // 执行  
        } catch (SQLException e) {
            close(rs, cs, conn);    
            e.printStackTrace();// 开发阶段  
            throw new RuntimeException(e.getMessage());  
        } catch (Exception e) {
            close(rs, cs, conn);  
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {  
            // 关闭资源  
            close(rs, ps, conn);  
        }  
    }  
    

    /*
     * 读取单个返回值
     */
    public static Object executeScalar(String connstr,String sql, String[] parameters){
    	RowSet rs=  executeQuery(connstr,sql,parameters);
    	Object obj = null;
    	try {
			while(rs.next()){
				obj = rs.getObject(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return obj;
    }
    
    // select  
    public static RowSet executeQuery(String connstr,String sql, String[] parameters) {  
        ResultSet rs = null;  
        Connection conn = null;  
        PreparedStatement ps = null;
        CallableStatement cs = null; 
        //使用sun的默认RowSet实现
        CachedRowSetImpl rowset = null;
		try {
			rowset = new CachedRowSetImpl();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {  
            conn = getConnection(connstr);  
            ps = conn.prepareStatement(sql);  
            if (parameters != null) {  
                for (int i = 0; i < parameters.length; i++) {
                    ps.setString(i + 1, parameters[i]);  
                }  
            }  
            rs = ps.executeQuery();  
            rowset.populate(rs);
        } catch (SQLException e) { 
        	close(rs, cs, conn);
            e.printStackTrace();  
            throw new RuntimeException(e.getMessage());  
        } catch (Exception e) {
        	close(rs, cs, conn);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {  
			close(rs, cs, conn);
        }  
        return rowset;  
    }  
  
    // 调用无返回值存储过程  
    // 格式： call procedureName(parameters list)  
    public static void callProc(String connstr,String sql, String[] parameters) { 
    	Connection conn = null;  
        ResultSet rs = null;  
        CallableStatement cs = null; 
        try {  
            conn = getConnection(connstr);  
            cs = conn.prepareCall(sql);  
            // 给？赋值  
            if (parameters != null) {  
                for (int i = 0; i < parameters.length; i++)  
                    cs.setObject(i + 1, parameters[i]);  
            }  
            cs.execute();  
        } catch (Exception e) {  
            close(rs, cs, conn);  
            e.printStackTrace();  
            throw new RuntimeException(e.getMessage());  
        } finally {  
            // 关闭资源  
            close(rs, cs, conn);  
        }  
    }  
  
    // 调用带有输入参数且有返回值的存储过程  
    public static CallableStatement callProcInput(String connstr,String sql, String[] inparameters) {
    	Connection conn = null;  
        CallableStatement cs = null; 
        try {  
            conn = getConnection(connstr);  
            cs = conn.prepareCall(sql);  
            if(inparameters!=null)  
                for(int i=0;i<inparameters.length;i++)  
                    cs.setObject(i+1, inparameters[i]);                 
            cs.execute();  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
            throw new RuntimeException(e.getMessage());  
        }finally{  
             
        }  
        return cs;  
    }  
     
    // 调用有返回值的存储过程  
    public static CallableStatement callProcOutput(String connstr,String sql,Integer[] outparameters) { 
    	Connection conn = null; 
        CallableStatement cs = null; 
        try {  
            conn = getConnection(connstr);  
            cs = conn.prepareCall(sql);                     
            //给out参数赋值  
            if(outparameters!=null)  
                for(int i=0;i<outparameters.length;i++)  
                    cs.registerOutParameter(i+1, outparameters[i]);  
            cs.execute();  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
            throw new RuntimeException(e.getMessage());  
        }finally{  
             
        }  
        return cs;  
    }  
  
    public static void close(ResultSet rs, Statement ps, Connection conn) {  
        if (rs != null)  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        rs = null;  
        if (ps != null)  
            try {  
                ps.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        ps = null;  
        if(conn != null){

            try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

           // int a = DataSourceUtil.getDruidDataSource(DataSourceUtil.TYPE_MySQL).removeAbandoned();  

       }
    }
}  
  