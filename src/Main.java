import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int chon;
        System.out.println("=== START MAIN ===");
        String menu =
                "CHƯƠNG TRÌNH QUẢN LÝ SÁCH\n" +
                        "1 Thêm 1 cuốn sách\n" +
                        "2 Xóa 1 cuốn sách\n" +
                        "3 Thay đổi cuốn sách\n" +
                        "4 Xuất thông tin tất cả sách\n" +
                        "5 Tìm sách có tiêu đề chứa \"lập trình\"\n" +
                        "6 Lấy sách tối đa theo giá\n" +
                        "7 Tìm sách theo tác giả\n" +
                        "0 Thoát\n" +
                        "Chọn chức năng: ";
        do {
            System.out.print(menu);
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1 -> {
                    Book b = new Book();
                    b.input();
                    listBook.add(b);
                }
                case 2 -> {
                    System.out.print("Nhập mã sách cần xóa: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Book find = listBook.stream()
                            .filter(b -> b.getId() == id)
                            .findFirst()
                            .orElse(null);
                    if (find != null) {
                        listBook.remove(find);
                        System.out.println("Đã xóa sách thành công");
                    } else {
                        System.out.println("Không tìm thấy sách");
                    }
                }
                case 3 -> {
                    System.out.print("Nhập mã sách cần sửa: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Book find = listBook.stream()
                            .filter(b -> b.getId() == id)
                            .findFirst()
                            .orElse(null);
                    if (find != null) {
                        find.input();
                        System.out.println("Đã cập nhật sách");
                    } else {
                        System.out.println("Không tìm thấy sách");
                    }
                }
                case 4 -> {
                    System.out.println("Danh sách sách:");
                    listBook.forEach(Book::output);
                }
                case 5 -> {
                    listBook.stream()
                            .filter(b -> b.getTitle()
                                    .toLowerCase()
                                    .contains("lập trình"))
                            .forEach(Book::output);
                }
                case 6 -> {
                    System.out.print("Nhập K: ");
                    int K = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập giá P: ");
                    double P = Double.parseDouble(sc.nextLine());

                    listBook.stream()
                            .filter(b -> b.getPrice() <= P)
                            .limit(K)
                            .forEach(Book::output);
                }
                case 7 -> {
                    System.out.print("Nhập số tác giả: ");
                    int n = Integer.parseInt(sc.nextLine());
                    Set<String> authors = new HashSet<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập tác giả " + (i + 1) + ": ");
                        authors.add(sc.nextLine().toLowerCase());
                    }
                    listBook.stream()
                            .filter(b -> authors.contains(
                                    b.getAuthor().toLowerCase()))
                            .forEach(Book::output);
                }
                case 0 -> System.out.println("Kết thúc chương trình");

                default -> System.out.println("Chức năng không hợp lệ");
            }
        } while (chon != 0);
    }
}
