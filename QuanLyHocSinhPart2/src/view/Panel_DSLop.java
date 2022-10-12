package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CSDL_sqlSv.HocSinhDAO;

import CSDL_sqlSv.LopDAO;

import model.HocSinh;

import model.Lop;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_DSLop extends JPanel {
	private JTable table_dsLop;
	private JTextField tf_TenLopTao;
	private JTextField tf_SiSo;
	private JTextField tf_maLop;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public Panel_DSLop() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(1430, 730);
		
	
		
		JLabel lblNewLabel = new JLabel("Danh sách lớp học");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(610, 37, 292, 69);
		add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 141, 371, 578);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên lớp");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 210, 62, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sĩ số");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 267, 48, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btn_tao_capNhat = new JButton("");
		btn_tao_capNhat.setIcon(new ImageIcon(Panel_DSLop.class.getResource("/view/image/success-icon.png")));
		btn_tao_capNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonTaoAndCapNhatLop();
			}
		});

		btn_tao_capNhat.setForeground(new Color(0, 0, 0));
		btn_tao_capNhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_tao_capNhat.setBackground(new Color(211, 211, 211));
		btn_tao_capNhat.setBounds(232, 200, 121, 40);
		panel_1.add(btn_tao_capNhat);
		
		JButton btnXoa_lop = new JButton("");
		btnXoa_lop.setIcon(new ImageIcon(Panel_DSLop.class.getResource("/view/image/Close-2-icon.png")));
		btnXoa_lop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonXoa();
			}
		});

		btnXoa_lop.setBackground(new Color(211, 211, 211));
		btnXoa_lop.setForeground(new Color(0, 0, 0));
		btnXoa_lop.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa_lop.setBounds(232, 257, 121, 40);
		panel_1.add(btnXoa_lop);
		
		tf_TenLopTao = new JTextField();
		tf_TenLopTao.setForeground(new Color(0, 0, 0));
		tf_TenLopTao.setBounds(68, 210, 140, 30);
		panel_1.add(tf_TenLopTao);
		tf_TenLopTao.setColumns(10);
		
		tf_SiSo = new JTextField();
		tf_SiSo.setForeground(new Color(0, 0, 0));
		tf_SiSo.setColumns(10);
		tf_SiSo.setBounds(68, 267, 140, 30);
		panel_1.add(tf_SiSo);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã lớp");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 147, 62, 30);
		panel_1.add(lblNewLabel_1_2);
		
		tf_maLop = new JTextField();
		tf_maLop.setForeground(new Color(0, 0, 0));
		tf_maLop.setColumns(10);
		tf_maLop.setBounds(68, 147, 140, 30);
		panel_1.add(tf_maLop);
		
		JLabel lblToLp = new JLabel("Thông tin lớp");
		lblToLp.setForeground(new Color(255, 255, 255));
		lblToLp.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblToLp.setBounds(147, 26, 157, 46);
		panel_1.add(lblToLp);
		
		JButton btn_timLop = new JButton("");
		btn_timLop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonTimKiem();
			}
		});

		btn_timLop.setIcon(new ImageIcon(Panel_DSLop.class.getResource("/view/image/Very-Basic-Search-icon.png")));
		
		btn_timLop.setForeground(new Color(0, 0, 0));
		btn_timLop.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_timLop.setBackground(new Color(211, 211, 211));
		btn_timLop.setBounds(232, 137, 121, 40);
		panel_1.add(btn_timLop);
		JLabel label = new JLabel("");
		label.setBounds(10, 15, 140, 115);
		setImgae(label);
		add(label);
		
		taoJcrollPaneRong();
		
		hienThiAllLop();
		
	}
	public void setImgae(JLabel label) {
		
		java.net.URL url = ViewTrangChu.class.getResource("logoTHCS ChoChu.jpg");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		label.setIcon(newIcon);
	}
	
	public void taoJcrollPaneRong() {
		table_dsLop = new JTable();
		table_dsLop.setEnabled(false);
		table_dsLop.setFillsViewportHeight(true);
		table_dsLop.setForeground(new Color(30, 144, 255));
		table_dsLop.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_dsLop.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 l\u1EDBp", "T\u00EAn l\u1EDBp", "S\u0129 s\u1ED1"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_dsLop.getColumnModel().getColumn(0).setPreferredWidth(29);
		
		table_dsLop.setRowHeight(30);
		
		JScrollPane src = new JScrollPane();
		src.setBounds(391, 141, 1029, 578);
		src.setViewportView(table_dsLop);
		
		scrollPane = src;
		
		
		add(scrollPane);
		
		
	}
	
	public void hienThiAllLop() {
		this.remove(scrollPane);
		taoJcrollPaneRong();
		
		ArrayList<Lop> lops = LopDAO.getLopDAO().selectAll();
		for (Lop lop : lops) {
			themLopVaoTable(lop);
			
			
		}

	}
	
	public void themLopVaoTable(Lop lop) {
		DefaultTableModel tableModel = (DefaultTableModel) table_dsLop.getModel();
		int i_row = (Integer) tableModel.getRowCount();
		tableModel.addRow(new Object[] {
				i_row,
				lop.getMaLop().trim() + "",
				lop.getTenLop().trim() + "",
				lop.getSiSo() + "".trim()
				
		});
	}
	
	public Lop getDuLieuJTextField() {
		Lop lop = null;
		try {
			String maLop = tf_maLop.getText();
			String tenLop = tf_TenLopTao.getText();
			int siso = Integer.valueOf(tf_SiSo.getText());
			lop = new Lop(maLop, tenLop, siso);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return lop;
	}

	public boolean kiemTraTonTai(Lop lop) {
		
		Lop t = LopDAO.getLopDAO().selectById(lop);
		
		if( t== null) {
			return false;
		}
		
		return true;
	}
	
	public boolean kiemTraMa() {
		
		String maLop = tf_maLop.getText();
		Lop lop = new Lop();
		lop.setMaLop(maLop);
		
		Lop lopKT = LopDAO.getLopDAO().selectById(lop);
		
		if( lopKT == null ) {
			return false;
		}
		return true;
		
	}
	
	
	public void buttonTaoAndCapNhatLop() {
		try {
			
			Lop lop = this.getDuLieuJTextField();
			
			if(this.kiemTraTonTai(lop)) {
				int luachon = JOptionPane.showConfirmDialog(this, "Lớp đã tồn tại,\nbạn "
						+ "có muốn cập nhật lớp không ?");
				if(luachon ==JOptionPane.YES_NO_OPTION) {
					LopDAO.getLopDAO().update(lop);
					hienThiAllLop();
				}
			}else {
				int luachon = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu thông tin "
						+ "lớp này không?");
				if(luachon ==JOptionPane.YES_NO_OPTION) {
					LopDAO.getLopDAO().insert(lop);
					hienThiAllLop();
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Lỗi: " + e);
		}

	}
	
	public void buttonXoa() {
		
		try {
			
			Lop lop = new Lop();
			lop.setMaLop(tf_maLop.getText());

			if(kiemTraMa()) {
				
				int luachon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa lớp có mã " +lop.getMaLop()+ " không?\n"
						+ "Nếu sẽ xóa thì học sinh của lớp này sẽ mất lớp!!");
				if(luachon ==JOptionPane.YES_NO_OPTION) {
					
					ArrayList<HocSinh> hocSinh_Lops = 
							HocSinhDAO.getHocSinhDAO().selectByCondition("MaLop = '" + lop.getMaLop() +"'" );
					
					for (HocSinh hocSinh : hocSinh_Lops) {
						HocSinhDAO.getHocSinhDAO().delete(hocSinh);
					}
					
					
					LopDAO.getLopDAO().delete(lop);
					
					hienThiAllLop();
				}
			}else {
				JOptionPane.showMessageDialog(this, "Lớp muốn xóa không hợp lệ");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(this, "Lớp muốn xóa không hợp lệ");
		}
	}
	
	public void themLopVaoFormNhap(Lop lop) {
		tf_maLop.setText(lop.getMaLop().trim());
		tf_TenLopTao.setText(lop.getTenLop().trim());
		tf_SiSo.setText( lop.getSiSo() + "".trim());

	}
	
	
	public void buttonTimKiem() {
		
		try {
			String maLop = tf_maLop.getText();
			Lop lop = new Lop();
			lop.setMaLop(maLop);
			
			Lop lop2 = LopDAO.getLopDAO().selectById(lop);
			themLopVaoFormNhap(lop2);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(this, "Hãy nhập mã lớp");
			
		}
		
		
		

	}
	
	
	
	
	
	
}
