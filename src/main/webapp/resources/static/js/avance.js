
document.addEventListener('DOMContentLoaded', function () {
    const AvanceRadios = document.querySelectorAll('input[name="avance"]');
    const montantField = document.getElementById('Montant');

    function toggleAvance() {
        if (AvanceRadios[0].checked) {
            montantField.style.display = 'block';
        } else {
            montantField.style.display = 'none';
        }
    }

    for (const radio of AvanceRadios) {
        radio.addEventListener('change', toggleAvance);
    }

    toggleAvance();
});
