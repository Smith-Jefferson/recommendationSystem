package recommentdation.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {

	public static void free(ResultSet resultset,Statement st,Connection conn) throws SQLException{

		try{
			if(resultset!=null)  
	            resultset.close();  
	        } catch (SQLException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
		finally  
        {  
            try  
            {  
                if(st!=null)  
                    st.close();  
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
            finally  
            {  
                if(conn!=null)
					ConnectPool.freeConnection(conn);  
            }  
        }  
		
	}
}
