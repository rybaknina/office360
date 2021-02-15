let viewer, container;

container = document.querySelector('#container');

viewer = new PANOLENS.Viewer({
    container: container,
    output: 'console',
    autoRotate: true,
    autoRotateSpeed: 1,
    autoRotateActivationDuration: 5000
});

for (let panorama of panoramas) {
    // some bug with duplicate and rewrite info - have to think about another dynamic variable (Nin personal opinion)
    window["panorama" + panorama.id] = new PANOLENS.ImagePanorama(panorama.imagePanorama);

    for (let person of panorama.persons) {
        if (person.active === true) {

            window["infospot" + person.id] = new PANOLENS.Infospot(150, PANOLENS.DataImage.Info);
            window["infospot" + person.id].position.set(person.positionX, person.positionY, person.positionZ);

            let personInfo = document.getElementById("person-container").getElementsByClassName("person-info")[0];

            personInfo.innerHTML =
                '<strong>' + person.firstName + ' ' + person.lastName + '</strong>' +
                '<br>'
                + "<a href='" + 'https://senla-portal.secure.force.com/portal/BasicPage?currentApp=PageProfile' + "' target=\"_blank\">Person Info on Portal</a>" +
                '<br>'
                + 'email: ' + person.email +
                '<br>'
                + 'skype: ' + person.skype +
                '<br>'
                + 'addition info: ' + person.info;
            window["infospot" + person.id].addHoverElement(document.getElementById('person-container'), 200);
            window["panorama" + panorama.id].add(window["infospot" + person.id]);

            window["infospot" + person.id].addEventListener('hoverenter', function () {
                window["infospot" + person.id].lockHoverElement();
            });
            window["infospot" + person.id].addEventListener('hoverenter', function () {
                window["infospot" + person.id].unlockHoverElement();
            });
        }
    }
    viewer.add(window["panorama" + panorama.id]);
}

for (let panoramaLink of panoramaLinks) {
    window["panorama" + panoramaLink.panoramaId].link(window["panorama" + panoramaLink.linkId],
        new THREE.Vector3(panoramaLink.positionX, panoramaLink.positionY, panoramaLink.positionZ),
        panoramaLink.imageScale, panoramaLink.imageLink);
}

var modal = document.getElementById("modal-plan");
var btn = document.getElementById("mapButton");
var btn1 = document.getElementById("mapButton12");
var btn2 = document.getElementById("mapButton15");
var btn3 = document.getElementById("mapButton20");

btn.onclick = function () {
    modal.style.display = "block";
}
btn1.onclick = function () {
    viewer.setPanorama(window["panorama" + 1]);
}

btn2.onclick = function () {
    viewer.setPanorama(window["panorama" + 2]);
}

btn3.onclick = function () {
    viewer.setPanorama(window["panorama" + 1]);
}

document.getElementById("rotateButton").onclick = function () {
    if (viewer.autoRotate) {
        viewer.enableAutoRate();
        viewer.autoRotate = false;
    } else {
        viewer.disableAutoRate();
        viewer.autoRotate = true;
    }
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
}
