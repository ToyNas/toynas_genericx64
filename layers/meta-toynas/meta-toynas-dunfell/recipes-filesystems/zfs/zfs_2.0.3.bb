SUMMARY = "ZFS"
DESCRIPTION="ZFS"
HOMEPAGE = "https://zfsonlinux.org/"
LICENSE = "CDDL"

LIC_FILES_CHKSUM = "file://LICENSE;md5=7087caaf1dc8a2856585619f4a787faa"

SRC_URI = "https://github.com/openzfs/zfs/releases/download/zfs-${PV}/zfs-${PV}.tar.gz"
SRC_URI[md5sum] = "???"
SRC_URI[sha256sum] = "???"

S = "${WORKDIR}/zfs-${PV}/"

inherit module kernel-module-split autotools autotools-brokensep

DEPENDS = "virtual/kernel zlib util-linux libtirpc openssl"

PACKAGES += "zfs-tools"

EXTRA_OECONF_append = " --with-linux=${STAGING_KERNEL_DIR} --with-linux-obj=${STAGING_KERNEL_BUILDDIR} --disable-pyzfs --enable-systemd --disable-sysvinit --without-dracutdir "
MODULE_NAME = "zfs"

PKG_${PN} = "kernel-module-${MODULE_NAME}"

do_install_append () {
    rm -rf ${D}/etc/sudoers.d
    rm -rf ${D}/usr/share/initramfs-tools
    rm -rf ${D}/usr/share/zfs
}

FILES_zfs-tools += "${sysconfdir}/zfs/* \
                    ${sysconfdir}/default/* \
                    ${libexecdir}/zfs/* \
                    ${bindir}/* \
                    ${sbindir}/* \
                    ${libdir}/udev/* \
                    ${base_libdir}/udev/* \
                    ${base_sbindir}/* \
                    ${libdir}/*"

FILES_${PN}-dev += "${prefix}/src/zfs-${PV}/* ${prefix}/src/spl-${PV}/* "

KERNEL_MODULE_AUTOLOAD += "zfs"