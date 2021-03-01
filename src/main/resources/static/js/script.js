let viewer, container;
var personInfo;

container = document.querySelector('#container');
personInfo = document.querySelector('#person-info');

viewer = new PANOLENS.Viewer({
    container: container,
    output: 'console',
    autoRotate: true,
    autoRotateSpeed: 1,
    autoRotateActivationDuration: 5000
});

let panoramaArray = [];
let infospotArray = [];

for (let panorama of panoramas) {
    panoramaArray[panorama.id] = new PANOLENS.ImagePanorama(panorama.imagePanorama);

    for (let person of panorama.persons) {
        if (person.active === true) {

            infospotArray[person.id] = new PANOLENS.Infospot(150, PANOLENS.DataImage.Info);
            infospotArray[person.id].position.set(person.positionX, person.positionY, person.positionZ);

            // think about font-size and photo of the employee
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

            infospotArray[person.id].addHoverElement(personInfo, 200);
            panoramaArray[panorama.id].add(infospotArray[person.id]);

            infospotArray[person.id].addEventListener('hoverenter', function () {
                infospotArray[person.id].lockHoverElement();
            });
            infospotArray[person.id].addEventListener('hoverenter', function () {
                infospotArray[person.id].unlockHoverElement();
            });
        }
    }
    viewer.add(panoramaArray[panorama.id]);
}

for (let panoramaLink of panoramaLinks) {
    panoramaArray[panoramaLink.panoramaId].link(panoramaArray[panoramaLink.linkId],
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
