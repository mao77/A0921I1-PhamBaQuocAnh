let userName = prompt("who 's there?");
if (userName == 'Admin') {
    let pass = prompt('nhap password vao day');
    if (pass == 'TheMaster') {
        alert('Welcome!');
    } else if (pass == null) {
        alert('Canceled.');
    } else {
        alert('Wrong password');
    }
} else if (userName == null) {
    alert('cancel');
} else {
    alert('i dont know you');
}