package dao.media;

import entity.db.AIMSDB;
import entity.media.Book;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @author
 */

//Các lớp DAO 'CÓ THỂ' sử dụng template method bằng cách extends lớp cha như sau:
//          public class DAO{
	
// 	            public Object templateMethod(String sql){
// 		            ResultSet res = getResultSet(sql);
// 	        	    Object ob = createObject(res);
// 	        	    return ob;
// 	            }
	
// 	            public ResultSet getResultSet(String sql){
// 	        	    ResultSet res =  AIMSDB.getConnection().createStatement().executeQuery(sql);
// 	        	    return res;
// 	            }
// 	             public abstract Object createObject(ResultSet res){
// 	            }
	
//      }
public class BookDAO extends MediaDAO {

    @Override
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM "+
                "aims.Book " +
                "INNER JOIN aims.Media " +
                "ON Media.id = Book.id " +
                "where Media.id = " + id + ";";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if(res.next()) {

            // from Media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from Book table
            String author = res.getString("author");
            String coverType = res.getString("coverType");
            String publisher = res.getString("publisher");
            Date publishDate = res.getDate("publishDate");
            int numOfPages = res.getInt("numOfPages");
            String language = res.getString("language");
            String bookCategory = res.getString("bookCategory");

            return new Book(id, title, category, price, quantity, type,
                    author, coverType, publisher, publishDate, numOfPages, language, bookCategory);

        } else {
            throw new SQLException();
        }
    }
}
