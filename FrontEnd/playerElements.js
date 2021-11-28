import { secondsToMinutes } from "./utils.js";

export default {
  get() {
    this.title = document.querySelector(".card-content h5");
    this.btn_previous = document.querySelector("#btn_previous");
    this.playPause = document.querySelector("#play-pause");
    this.btn_next = document.querySelector("#btn_next");
    this.mute = document.querySelector("#mute");
    this.volume = document.querySelector("#vol-control");
    this.seekbar = document.querySelector("#seekbar");
    this.currentDuration = document.querySelector("#current-duration");
    this.totalDuration = document.querySelector("#total-duration");

    this.btn_select_economy = document.querySelector("#economy");
    this.btn_select_policy = document.querySelector("#politic");
    this.btn_select_social = document.querySelector("#social");
    this.btn_select_international = document.querySelector("#international");
    this.subject = document.querySelector("#specific-subject-name");
  },
  createAudioElement(audio) {
    this.audio = new Audio(audio);
  },
  actions() {
    this.btn_next.onclick = () => this.next();
    this.btn_previous.onclick = () => this.previous();
    this.audio.ontimeupdate = () => this.timeUpdate();
    this.playPause.onclick = () => this.togglePlayPause();
    this.mute.onclick = () => this.toggleMute();
    this.volume.oninput = () => this.setVolume(this.volume.value);
    this.volume.onchange = () => this.setVolume(this.volume.value);
    this.seekbar.oninput = () => this.setSeek(this.seekbar.value);
    this.seekbar.onchange = () => this.setSeek(this.seekbar.value);
    this.seekbar.max = this.audio.duration;
    this.totalDuration.innerText = secondsToMinutes(this.audio.duration);

    this.btn_select_economy.onclick = () => this.setSubjectToEconomy();
    this.btn_select_policy.onclick = () => this.setSubjectToPolicy();
    this.btn_select_social.onclick = () => this.setSubjectToSocial();
    this.btn_select_international.onclick = () => this.setSubjectToInternational();
  }
};
