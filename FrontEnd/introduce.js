
window.onload = function(){
    let state_crew = 0;
    let state_website = 0;
    document.getElementById('introduction_to_crew').style.display = 'none';

    document.getElementById('btn_collapse_crew').onclick =  function(){
        if(state_crew == 0){
            document.getElementById('introduction_to_crew').style.display = "";
            state_crew = 1;
        }
        else{
            document.getElementById('introduction_to_crew').style.display = 'none';
            state_crew = 0;
        }
    };

    document.getElementById('btn_collapse_website').onclick =  function(){
        if(state_crew == 0){
            document.getElementById('introduction_to_website').style.display = "";
            state_crew = 1;
        }
        else{
            document.getElementById('introduction_to_website').style.display = 'none';
            state_crew = 0;
        }
    };
};
