setEventListeners();

function setEventListeners() {

    setSubmitEventListeners();
}

function setSubmitEventListeners() {
    const submitButton = document.querySelector('.place-bet-button');
    const betPrice = document.getElementById('betPrice');
    const auctionStep = document.getElementById('auction-step');
    let newMinBet = betPrice.value + auctionStep.value;
    betPrice.setAttribute('min', newMinBet);
    submitButton.addEventListener('click', function (event) {
        event.preventDefault();
        if (validateAllInputs()) {
            const form = document.querySelector('.lot-place-bet-form');
            form.submit();
        }
    });
}


function validateAllInputs() {
    const currentBet = document.querySelector('.current-bet').value;
    const step = document.querySelector('.auction-step').value;
    const newCurrentBet = document.querySelector('.bet-field').value;

    if (newCurrentBet > currentBet + step) {
        return true;
    }

    if (!(newCurrentBet > currentBet + step)) {
        document.querySelector('.error-new-bet').classList.remove('hidden');
    }
    else {
        document.querySelector('.error-new-bet').classList.add('hidden');
    }

    return false;
}