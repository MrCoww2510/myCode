class CucLapXuong{
    public int thit;
    public CucLapXuong soiday;
    public CucLapXuong(){}
    public CucLapXuong(int thit){
        this.thit = thit;
        this.soiday = null;
    }
}

public class ChuoiLapXuong {
    public CucLapXuong cuclapxuongdautien;
    // Hàm khởi tạo
    public ChuoiLapXuong(){
        cuclapxuongdautien = null;
    }

    // Thêm vào đầu
    public void themcuclapxuongvaodauchuoi(int thit){
        CucLapXuong cuclapxuongmoi = new CucLapXuong(thit); 

        if (cuclapxuongdautien == null){
            cuclapxuongdautien = cuclapxuongmoi;
        }  else {
            cuclapxuongmoi.soiday = cuclapxuongdautien;
            cuclapxuongdautien = cuclapxuongmoi;
        }
    }
    // Thêm vào cuối
    public void themcuclapxuongvaocuoichuoi(int thit){
        CucLapXuong cuclapxuongmoi = new CucLapXuong(thit);

        if (cuclapxuongdautien == null){
            cuclapxuongdautien = cuclapxuongmoi;
        } else {
            CucLapXuong cuclapxuongtamdau =  cuclapxuongdautien;
            while (cuclapxuongtamdau.soiday != null){
                cuclapxuongtamdau = cuclapxuongtamdau.soiday;
                }
            cuclapxuongtamdau.soiday = cuclapxuongmoi;
            }
    }
    // Thêm vào giữa
    public void themcuclapxuongvaogiuachuoi(int thit, int vitri){
        CucLapXuong cuclapxuongmoi = new CucLapXuong(thit);

        if (cuclapxuongdautien == null){
            cuclapxuongdautien = cuclapxuongmoi;
        } else {
            CucLapXuong cuclapxuongtam = cuclapxuongdautien;
            while (cuclapxuongtam != null && cuclapxuongtam.thit != vitri){
                 cuclapxuongtam = cuclapxuongtam.soiday;
                }
                cuclapxuongmoi.soiday = cuclapxuongtam.soiday;
                cuclapxuongtam.soiday = cuclapxuongmoi;
            }
    }
}