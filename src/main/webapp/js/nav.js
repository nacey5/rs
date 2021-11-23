window.addEventListener('load', function () {
    var nav = this.document.querySelector('.nav');
    var lis = nav.querySelectorAll('li');
    for (let i = 0; i < lis.length; i++) {
        lis[i].addEventListener('click', function () {
            for (let j = 0; j < lis.length; j++) {
                lis[j].classList.remove ('cur') ;//去除图片的img-active
            }
            this.classList.add('cur');
        })
    }
})