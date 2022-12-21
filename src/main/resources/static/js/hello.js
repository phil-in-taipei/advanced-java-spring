function greeting() {
    alert("Hello Spring Developer!!");
    toggleColorTenTimes();
}

function toggleHeadingColor() {
    let allHeadings =document.getElementsByName("heading");
    console.log(allHeadings);
    for (let i = 0; i < allHeadings.length; i++) {
        console.log(allHeadings[i].style.color === "rgb(255, 0, 0)");
        if(allHeadings[i].style.color === "rgb(255, 0, 0)"){
            allHeadings[i].style.color = "black";
        } else {
            allHeadings[i].style.color = "#FF0000";
        }

    }
}

function toggleColorTenTimes() {
    //for(i=0; i < 5; i++) {
    //   console.log("Changing color in 3 seconds:")
    //   setTimeout(toggleHeadingColor, 3000);
    //}
    setInterval(toggleHeadingColor, 3000);
}

