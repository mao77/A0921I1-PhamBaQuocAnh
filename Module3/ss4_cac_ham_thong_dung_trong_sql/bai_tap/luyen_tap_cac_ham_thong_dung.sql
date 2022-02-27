/*Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.*/
select * from subject having credit >= all(select credit from subject);

/*Hiển thị các thông tin môn học có điểm thi lớn nhất.*/
select mark.subID, subject.subName ,max(mark) max_mark from mark join subject on mark.subID = subject.subID group by mark.subID;

/*Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần*/
select s.studentID,s.studentName,avg(m.mark) from mark as m 
join student as s on m.studentID = s.studentID
group by studentID;
