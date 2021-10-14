var diemVatLy = prompt('Nhap vao diem vat ly');
var diemHoa = prompt('Nhap vao diem Hoa');
var diemSinh = prompt('Nhap vao diem Sinh');
var ly = parseFloat(diemVatLy);
var hoa = parseFloat(diemHoa);
var sinh = parseFloat(diemSinh);
var diemTrungBinh = (ly + hoa + sinh)/3;
document.write('diem trung binh= '+ parseFloat(diemTrungBinh).toFixed(1));