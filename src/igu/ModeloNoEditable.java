package igu;

import javax.swing.table.*;

public class ModeloNoEditable extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	public ModeloNoEditable(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> clase = Object.class;
		Object aux = getValueAt(0, columnIndex);
		if (aux != null) {
			clase = aux.getClass();
		}

		return clase;
	}
}
