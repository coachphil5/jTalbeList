import javax.swing.table.AbstractTableModel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by JOINTJUICE on 3/19/14.
 */
public class InsertFileDataToJTable extends AbstractTableModel {
    Vector data;
    Vector columns;

    public InsertFileDataToJTable() {
        String line;
        data = new Vector();
        columns = new Vector();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.home") + "/Desktop/phonelist.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringTokenizer st1 = new StringTokenizer(br.readLine(), "\t");
            while (st1.hasMoreTokens())
                columns.addElement(st1.nextToken());
            while ((line = br.readLine()) != null) {
                StringTokenizer st2 = new StringTokenizer(line, "\t");
                while (st2.hasMoreTokens())
                    data.addElement(st2.nextToken());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        return data.size() / getColumnCount();
    }

    public int getColumnCount() {
        return columns.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return (String) data.elementAt((rowIndex * getColumnCount())
                + columnIndex);
    }

    public String getColumnName(int col) {
        return columns.get(col).toString();
    }
}
