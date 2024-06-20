package io.mymanager.desktop.data.models;

import javax.swing.JTable;

public class MyTable extends JTable {

  /**
   *
   */
  private static final long serialVersionUID = 5395934568879333080L;

  public boolean isCellEditable(int row, int column) {
    return false;
  }
}
