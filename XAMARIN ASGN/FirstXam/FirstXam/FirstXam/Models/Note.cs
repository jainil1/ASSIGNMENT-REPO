﻿using System;
using System.Collections.Generic;
using System.Text;
using SQLite;

namespace FirstXam. Models
{
    public class Note
    {
        [PrimaryKey, AutoIncrement]
        public int ID { get; set; }
        public string FileName
        {
            get;set;
        }
        public string Text
        {
            get; set;
        }

    }
}
