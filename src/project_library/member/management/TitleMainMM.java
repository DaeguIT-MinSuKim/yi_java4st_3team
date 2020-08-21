package project_library.member.management;

import java.awt.EventQueue;

public class TitleMainMM {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManagement frame = new MemberManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

	}

}
