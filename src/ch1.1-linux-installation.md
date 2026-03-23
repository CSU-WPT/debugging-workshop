# How to install Linux

Linux can be installed in a variety of ways, but it almost always starts with downloading the distribution's install ISO. Here are the links to a few common distros:

* Ubuntu: <https://ubuntu.com/download/desktop>
* Debian: <https://www.debian.org/distrib/>
* Kali Linux: <https://www.kali.org/get-kali>
* Linux Mint: <https://www.linuxmint.com/download.php>
* Fedora: <https://fedoraproject.org/workstation/>

## Installing on a Physical Machine

Once you have downloaded the ISO, use a USB flashing program (any of the below) to write the ISO to a USB drive.
* Window: [Rufus](https://rufus.ie/en/)
* MacOS / Linux:
    * [Balena Etcher](https://etcher.balena.io/)
    * The `dd` command command for experienced users
* Linux:
    * [Popsicle](https://github.com/pop-os/popsicle)
    * [KDE ISO Image Writer](https://apps.kde.org/isoimagewriter/)

Once the USB drive is written, boot the machine from the USB drive (using a BIOS or UEFI boot menu) and follow the instructions provided by the distro's installer.

## Installing on a Virtual Machine

Setting up a virtual machine is a great way to play with and learn Linux without having to install it on a physical machine. We recommend using [Oracle VirtualBox](https://www.virtualbox.org/) for this purpose since it's free and open source. You can download it here: <https://www.virtualbox.org/wiki/Downloads>.

To setup a linux Virtual Machine (VM), follow this guide: <https://ubuntu.com/tutorials/how-to-run-ubuntu-desktop-on-a-virtual-machine-using-virtualbox#1-overview>. It's written for Ubuntu, but the steps for booting from the ISO image should be almost identical for other distros.

## Installing via WSL (no ISO) (Windows only)
For Windows computers with Windows 10 or 11, this is an easy way to use the Ubuntu terminal on top of your system without partitioning your hard drive or using a virtual machine. Windows essentially treats it like another program on the computer, so you run it anytime you like from the Start Menu or from the terminal drop-down menu.
* To install WSL, open the terminal in administrator mode and execute:
   ```
   wsl --install
   ```
* Once it is installed, restart, and then you can then go ahead and set up our Linux username and password when it comes back up
* Once you are signed into to your Ubuntu account, update and upgrade the system
  ```
  sudo apt update && sudo apt upgrade -y
  ```
* Close the window
* You can now access Ubuntu
   * from the Start menu by selecting/searching for WSL or Ubuntu
   * by opening the terminal and running the command:
     ```
     wsl
     ```
     or
     ```
     ubuntu
     ```
        * run the `exit` command to return to the windows terminal
   * by selecting Ubuntu from the dropdown menu at the top of the terminal window
* Now that it is all set up, you access and manipulate all the files on your computer using Ubuntu
* This can be very useful for testing C code that needs to run on the CSU Linux computers for homework.
