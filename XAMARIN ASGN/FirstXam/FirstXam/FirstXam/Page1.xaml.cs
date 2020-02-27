using System;
using System.IO;
using System.Linq;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using FirstXam.Models;

namespace FirstXam
{
    
    public partial class Page1 : ContentPage
    {
        public Page1()
        {
            InitializeComponent();
        }
       /* async void onSave(object sender, EventArgs e)
        {
            Console.WriteLine ("yay");
            var n = (Note)BindingContext;
            var filename = Path.Combine(App.FolderPath,"*.mynotes.txt");
            //  File.WriteAllText(n.FileName,n.text);
            File.WriteAllText(n.FileName, n.Text);
            await Navigation.PopAsync();

            
        }
        async void onDelete(object sender, EventArgs e)
        {
            var n = (Note)BindingContext;
            if (File.Exists(n.FileName))
            {
                File.Delete(n.FileName);
            }
            await Navigation.PopAsync();
        }*/

        async void Button_Clicked(object sender, EventArgs e)
        {
            /*Console.WriteLine("yay");
            var n = (Note)BindingContext;
            var filename = Path.Combine(App.FolderPath, "*.mynotes.txt");
            //  File.WriteAllText(n.FileName,n.text);
            File.WriteAllText(n.FileName, n.Text);
            await Navigation.PopAsync()*/
            var n = (Note)BindingContext;
            await App.Database.SaveNote(n);
            await Navigation.PopAsync();

        }

        async void Button_Clicked_1(object sender, EventArgs e)
        {
            var n = (Note)BindingContext;
            /*if (File.Exists(n.FileName))
            {
                File.Delete(n.FileName);
            }*/
            await App.Database.DeleteNote(n);

            await Navigation.PopAsync();
        }
    }
}