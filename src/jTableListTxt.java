import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.Color;

/**
 * Created by JOINTJUICE on 3/19/14.
 */
public class jTableListTxt {
  private JPanel panel1;
  /*  private JTable table1;
    private JScrollPane jScroll1;
*/
    public static void main(String[] args) {
        InsertFileDataToJTable model = new InsertFileDataToJTable();
        JTable table = new JTable(model) {
            public Component prepareRenderer(TableCellRenderer renderer, int Index_row, int Index_col) {
                // get the current row
                Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
                // even index, not selected
                if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
                    comp.setBackground(Color.lightGray);
                } else {
                    comp.setBackground(Color.white);
                }
                return comp;
            }
        };

        JScrollPane scrollpane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollpane);
        JFrame frame = new JFrame();
        frame.add(panel, "Center");
        frame.pack();
        frame.setVisible(true);
    }
}

