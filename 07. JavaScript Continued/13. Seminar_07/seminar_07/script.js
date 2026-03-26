const videoPlayerElement = document.getElementById("videoPlayer");
const playElement = document.getElementById("play");
const pauseElement = document.getElementById("pause");
const stopElement = document.getElementById("stop");
const progressElement = document.getElementById("progressControl");
const volumeElement = document.getElementById("volumeControl");


// Запускаем видео, активация кнопки play и pause
// Отключение кнопки play
function playVideo() {
  videoPlayerElement.play();
  playElement.disabled = true;
  pauseElement.disabled = false;
  stopElement.disabled = false;
}

// Приостановка воспроизведения video,
// активация кнопки play и отключение кнопки stop и pause
function pauseVideo() {
  videoPlayerElement.pause();
  playElement.disabled = false;
  pauseElement.disabled = true;
  stopElement.disabled = false;
}

// Остановка воспроизведения видео, возврат к началу,
// активация кнопки play и отключение кнопки pause и stop
function stopVideo() {
  videoPlayerElement.pause();
  videoPlayerElement.currentTime = 0;
  playElement.disabled = false;
  pauseElement.disabled = false;
  stopElement.disabled = true;
}

// Обновление полосы прогресса
function reportProgress() {
  const progress =
    (videoPlayerElement.currentTime / videoPlayerElement.duration) * 100;
  progressElement.value = progress;
}

// Перемотка видео при клике на полосу прогресса
function seekVideo() {
  const seekTime = (progressElement.value * videoPlayerElement.duration) / 100;
  videoPlayerElement.currentTime = seekTime;
}

// Регулировка громкости видео
function adjustVolume(e) {
  videoPlayerElement.volume = e.target.value;
}


// Добавляем обработчики событий для кнопок и видео
playElement.addEventListener("click", playVideo);
pauseElement.addEventListener("click", pauseVideo);
stopElement.addEventListener("click", stopVideo);
videoPlayerElement.addEventListener("timeupdate", reportProgress);
progressElement.addEventListener("input", seekVideo);
volumeElement.addEventListener("input", adjustVolume);
