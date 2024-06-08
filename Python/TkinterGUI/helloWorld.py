#this code is pre-build. I didn't wrote it
import gi

gi.require_version("Gtk", "3.0")
gi.require_version('Notify', '0.7')

from gi.repository import Gtk
from gi.repository import Notify

class MyWindow(Gtk.Window):
    def __init__(self):
        Gtk.Window.__init__(self, title="Hello World")
        Gtk.Window.set_default_size(self, 640, 480)
        Notify.init("Simple GTK3 Application")

        self.box = Gtk.Box(spacing=6)
        self.add(self.box)
       
        self.button = Gtk.Button(label="Hello")
        self.button.set_halign(Gtk.Align.CENTER)
        self.button.set_valign(Gtk.Align.CENTER)
        self.button.connect("clicked", self.on_button_clicked)
        self.box.pack_start(self.button, True, True, 0)

    def on_button_clicked(self, widget):
        n = Notify.Notification.new("Simple GTK3 Application", "Hello World !!")
        n.show()

win = MyWindow()
win.connect("destroy", Gtk.main_quit)
win.show_all()
Gtk.main()
