package kwalker.nnk.management.enums;

public class Message {
	public static final String SAVE_SUCCESSFULLY = "Thông tin sinh viên đã được cập nhật!";

	public static final String DELETE_SUCCESSFULLY(String name) {
		return "Bạn đã xoá sinh viên " + name + " ra khỏi hệ thống!";
	};

	public static final String DELETED_ALL_SUCCESSFULLY = "Đã xoá tất cả sinh viên ra khỏi hệ thống!";

	public static final String DELETION_FAILED = "Xin lỗi, chúng tôi không tìm thấy CMND nào như vậy!";

	public static final String NOT_FOUND = "Không tìm thấy bất kì CMND nào như vậy để thực hiện hành động tiếp theo!";

}
