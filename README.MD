 ./balena-yocto-scripts/build/barys -m genericx86-64-ext -d -a GO111MODULE=on -a GOPROXY=https://goproxy.cn -a BALENA_DISABLE_KERNEL_HEADERS=1 --shared-sstate /home/focus/sstate-cache --shared-downloads /home/focus/downloads -a ENABLE_BINARY_LOCALE_GENERATION=1 -a GLIBC_GENERATE_LOCALES="en_GB.UTF-8 en_US.UTF-8 zh_CN.utf8"

