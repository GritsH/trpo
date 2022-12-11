export function validateEmail(email) {
    const regex = /(?:[a-z\d!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z\d!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z\d](?:[a-z\d-]*[a-z\d])?\.)+[a-z\d](?:[a-z\d-]*[a-z\d])?|\[(?:(?:25[0-5]|2[0-4]\d|[01]?\d\d?)\.){3}(?:25[0-5]|2[0-4]\d|[01]?\d\d?|[a-z\d-]*[a-z\d]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)])/;
    return email.match(regex);
}

export function validatePassword(password) {
    return password.length >= 6;
}

export function validatePhoneNumber(phoneNumber) {
    const regexPhone = /^[+]?[0-9]{3}?[-\s\.]?[0-9]{2}[-\s\.]?[0-9]{7}$/;
    return phoneNumber.match(regexPhone);
}

export function validatePassport(passport) {
    //const regexPassport = new RegExp('/^[A-Z]{2}\[0-9]{7}$/');
    const regexPassport = /^[A-Z]{2}\d{7}$/;

    return passport.match(regexPassport);
}

export function validateCarEngineVolume(carEngineVolume) {
    const regexEngineVolume = /^[0-9]+(\.[0-9]{1,2})$/;
    return carEngineVolume.match(regexEngineVolume);
}

export function validateManufactureYear(manufactureYear) {
    const regexManufactureYear = /^(19[4-9]\d|20[0-2]\d|2022)$/;
    return manufactureYear.match(regexManufactureYear);
}