function  convert() {
    let amount;
    let convert;
    amount = parseFloat(document.getElementById('amount').value);
    convert = (amount/23000).toFixed(2);
    document.write(amount+' VND = '+convert+' USD');
}