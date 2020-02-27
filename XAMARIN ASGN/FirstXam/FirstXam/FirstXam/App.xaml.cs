using System.IO;
using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using FirstXam.DATA;

namespace FirstXam
{
   
         
    public partial class App : Application
    {
        public static string FolderPath { get; private set; }
        static NodeDatabase database;

        public static NodeDatabase Database

        {
            get
            {
                if (database == null)
                {
                    database = new NodeDatabase(Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "Notes.db3"));
                }
                return database;
            }
        }
        public App()
        {
            InitializeComponent();
            FolderPath = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData));
                        MainPage = new NavigationPage(new Page2());
        }

        protected override void OnStart()
        {
        }

        protected override void OnSleep()
        {
        }

        protected override void OnResume()
        {
        }
    }
}
