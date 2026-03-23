# What is Linux?

Linux, or (more technically) GNU/Linux, is an open source operating system (or family of operating systems) created by Linus Torvalds in 1991. It has two main parts: the linux kernel, which interacts with the hardware, manages memory and processes, and does many other low-level tasks, and the user-land programs, which run on top of the kernel. User-land programs are supported by a set of system libraries. The most popular set of system libraries is the GNU C Library (hence the name GNU/Linux).

More info: <https://en.wikipedia.org/wiki/Linux>

However, you need more than just the kernel and set of system libraries to create a useful operating system setup. This is where Linux distributions comes in.

## What is a Linux distribution?

A Linux distribution (or "distro") is a collection of software that is bundled with the linux kernel (and often the GNU C Library) in order to provide a more complete operating system experience. This software bundle almost always include a package manager and a shell, and sometimes includes a graphical user interface (GUI). These distros are also characterized by how often they are updated. Some distros focus on stability, releasing twice a year, while others focus on the latest features, releasing ever one or two months (with package managers that update packages as often as possible).

There are many different operating systems for many different purposes, but some of the most popular ones are:

* [Ubuntu](https://ubuntu.com/)
    * One of the most popular Linux distributions
    * Focused on stability, with updates every 6 months
    * Based on Debian
* [Debian](https://www.debian.org/)
    * Another very popular Linux distribution
    * Uses the Debian package manager and Apt
* [Fedora](https://getfedora.org/)
* [Mint](https://linuxmint.com/)
* [Arch](https://archlinux.org/)
    * One of the most popular rolling-release Linux distribution
    * Uses the pacman package manager
    * For more advanced users, since it doesn't come with default desktop environment
* [Manjaro](https://manjaro.org/)
    * Based on Arch
* [Kali Linux](https://www.kali.org/)
    * Based on Debian
    * Includes many cyber security tools
* [Tails](https://tails.boum.org/)
    * An ephemeral Linux distribution, used only on live boot USBs

More info: <https://en.wikipedia.org/wiki/Linux_distribution>

## What is a Desktop Environment?

A desktop environment is a graphical user interface (GUI) that provides users with a way to interact with the operating system. It handles all graphical program windows, menus, and icons, along with the taskbar and other desktop widgets. A few popular desktop environments include:

* GNOME
* KDE
* Xfce
* MATE
* Cinnamon

More info: <https://en.wikipedia.org/wiki/Desktop_environment>

Most linux distributions meant for desktop use come with a pre-installed desktop environment. For example, Ubuntu comes with GNOME while Kubuntu, a spinoff of Ubuntu, comes with KDE. It is important to note basically any linux distribution can be used with any desktop environment. In fact, some distro websites (like <https://fedoraproject.org/spins/>) provide a download for each popular desktop environment. Arch is somewhat unique in that it doesn't come with a desktop environment at all. Instead, users will need to install one after installing the distro itself.

## Why should I care about Linux?

Because of Linux's quality and free licensing, it has become a popular choice for servers. In fact, "96.3% of the top one million web servers are running Linux" [^1]. That means that a strong majority developers need to develop products that run on Linux. Because of this and because Linux is free and flexible, many developers use Linux as their desktop operating system as well [^1].

Since there is no escaping linux, we strongly encourage young developers to start learning it.

[^1]: <https://truelist.co/blog/linux-statistics/>