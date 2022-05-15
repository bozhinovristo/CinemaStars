$(document).ready(function () {
    let t = $(".timestamp")
    t.each(function () {
        let timestamp = $(this).text()
        console.log(timestamp);
        let dateTimeDateObj;
        dateTimeDateObj = new Date(timestamp);
        console.log(dateTimeDateObj);
        let dateTimeDateObjString = dateTimeDateObj.toString('YYYY-MM-dd');
        console.log(dateTimeDateObjString);
        let dateTimeDateObjStringSplit = dateTimeDateObjString.split(" ");
        console.log(dateTimeDateObjStringSplit);
        let time = dateTimeDateObjStringSplit[4];
        console.log(time);
        time = time.slice(0, -3);
        console.log(time); //21:00
        let date = dateTimeDateObjStringSplit.slice(0, 4)
        console.log(date);
        date = date.join(" "); //Tue May 03 2022
        console.log(date);
        let dateAndTime = date + " at " + time;
        console.log(dateAndTime);
        $(this).text("");
        $(this).text(dateAndTime);
    })
});