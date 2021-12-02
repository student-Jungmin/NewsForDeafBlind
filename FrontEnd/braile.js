
window.onload = function(){
    let state_form = 0;
    let state_data = 0;
    let state_service = 0;
    document.getElementById('introduction_to_BraileNewsJSON').style.display = 'none';
    document.getElementById('introduction_to_data').style.display = 'none';

    document.getElementById('btn_collapse_form').onclick =  function(){
        if(state_form == 0){
            document.getElementById('introduction_to_BraileNewsJSON').style.display = "";
            state_form = 1;
        }
        else{
            document.getElementById('introduction_to_BraileNewsJSON').style.display = 'none';
            state_form = 0;
        }
    };

    document.getElementById('btn_collapse_data').onclick =  function(){
        if(state_data == 0){
            document.getElementById('introduction_to_data').style.display = "";
            state_data = 1;
        }
        else{
            document.getElementById('introduction_to_data').style.display = 'none';
            state_data = 0;
        }
    };

    document.getElementById('btn_collapse_service').onclick =  function(){
        if(state_data == 0){
            document.getElementById('introduction_to_braile').style.display = "";
            state_data = 1;
        }
        else{
            document.getElementById('introduction_to_braile ').style.display = 'none';
            state_data = 0;
        }
    };
};

