var currentStep = 1;
var stepsNum = 4;

// show default page
document.getElementById("stepPage" + currentStep).style.display = "block";
document.getElementById("stepLable" + currentStep).classList.add("activeStep");

// change step from current active step to a new active (next or previous)
function changeStep(active, newActive) {

    // get active step page and hide it
    document.getElementById("stepPage" + active).style.display = "none";

    // show new step page
    document.getElementById("stepPage" + newActive).style.display = "block";

    // get active step lable and remove class active
    var activeStepL = document.getElementsByClassName("activeStep")[0];
    activeStepL.classList.remove("activeStep");

    // get new active step lable, add class active
    var newActiveStepL = document.getElementById("stepLable" + newActive);
    newActiveStepL.classList.add("activeStep");

    // update progress bar
    var p = (100 / (stepsNum - 1)) * (newActive - 1);
    document.getElementById("completedProgress").style.width = p + "%";

    // if user moves to next step, add class completed to previous
    if(active < newActive) {
        activeStepL.classList.add("completedStep");

        // replace number with checkmark
        activeStepL.innerHTML = "<i style='font-size:40px' class='material-icons'>&#xe5ca;</i>";
    }

    // avoid overlap, remove class completed from new active
    if(newActiveStepL.classList.contains("completedStep")) {
        newActiveStepL.classList.remove("completedStep");

        // replace checkmark with step number
        newActiveStepL.innerHTML = newActive;
    }
}


function next() {
    if(currentStep >= stepsNum) {
        alert("complete :)");
    } else {
        changeStep(currentStep, currentStep + 1);
        currentStep++;
        document.getElementById("prev").style.visibility = "visible";
    }
}


function prev() {
    if(currentStep >= 2) {
        changeStep(currentStep, currentStep - 1);
        currentStep--;

        if(currentStep < 2) {
          document.getElementById("prev").style.visibility = "hidden";
        }
    }
}
