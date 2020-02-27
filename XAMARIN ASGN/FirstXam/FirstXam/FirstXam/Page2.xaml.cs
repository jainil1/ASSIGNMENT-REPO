using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FirstXam.Models;
using System.IO;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace FirstXam
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Page2 : ContentPage
    {
        public Page2()
        {
            InitializeComponent();
        }
        protected override async void OnAppearing()
        {
            base.OnAppearing();
            listView.ItemsSource = await App.Database.GetNotes();
            /*var n = new List<Note>();
            var files = Directory.EnumerateFiles(App.FolderPath, "*.mynotes.txt");
            foreach (var fn in files)
            {
                n.Add(new Note
                {
                    FileName = fn,
                    Text = File.ReadAllText(fn)

                });
            }
            listVi*//*listView.ItemsSource = n.ToList();
            listView.ItemsSource = await App.Database.GetNotes();*/

        }

        async void OnNoteAdded(object sender , EventArgs e)
        {
            await Navigation.PushAsync(new Page1{
                BindingContext = new Note()
            });

        }
        async void OnListViewItemSelected(object sender, SelectedItemChangedEventArgs e)
        {
            if (e.SelectedItem != null)
            {
                await Navigation.PushAsync(new Page1
                {
                    BindingContext = e.SelectedItem as Note
                });
            }
        }


    }
}