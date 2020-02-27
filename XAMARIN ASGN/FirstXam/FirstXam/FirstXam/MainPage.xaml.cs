using System;

using System.ComponentModel;

using Xamarin.Forms;
using System.IO;

namespace FirstXam
{
   
    [DesignTimeVisible(false)]
    public partial class MainPage : ContentPage
    {
        String fn = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "notes.txt");

        public MainPage()
        {   
            InitializeComponent();
            if (File.Exists(fn))
            {
                editor.Text = File.ReadAllText(fn);

            }
        }
        
        void onSave(object sender , EventArgs e)
        {
            File.WriteAllText(fn, editor.Text);
        }
        void onDelete(object sender, EventArgs e)
        {
            if (File.Exists(fn)){
                File.Delete(fn);
            }
            editor.Text = string.Empty;

        }
    }
}
