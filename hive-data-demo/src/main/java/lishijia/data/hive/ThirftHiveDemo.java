package lishijia.data.hive;
import java.sql.*;

/**
 * @program:
 * @description: 通过jdbc连接hive对外提供的接口服务（thrift）
 * @author: lishijia
 * @create: 2018/9/25 16:37
 **/
public class ThirftHiveDemo {

    String driverClass = "org.apache.hive.jdbc.HiveDriver";
    String url = "jdbc:hive2://hadoop100:10000/default";

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        ThirftHiveDemo thirftHiveDemo = new ThirftHiveDemo();
        thirftHiveDemo.search();
        System.out.println(System.currentTimeMillis()-l);
    }

    private void search(){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConn();
            System.out.println(conn);
            stmt = conn.createStatement();
            // hive表名
            String tableName = "st_order";
            String sql = "select * from " + tableName + " limit 10";
            System.out.println("Running:" + sql);
            ResultSet res = stmt.executeQuery(sql);
            System.out.println("执行 select * query 运行结果:");
            while (res.next()) {
                System.out.println(res.getString(1) + "\t" + res.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection getConn() throws ClassNotFoundException,
            SQLException {
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }

}
