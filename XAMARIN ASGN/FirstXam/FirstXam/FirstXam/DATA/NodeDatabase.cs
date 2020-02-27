using System.Collections.Generic;
using System.Threading.Tasks;
using SQLite;
using FirstXam.Models;

namespace FirstXam.DATA
{
    

    public class NodeDatabase
    {
        readonly SQLiteAsyncConnection _db;
        public NodeDatabase(string dbP)
        {
            _db = new SQLiteAsyncConnection(dbP);
            _db.CreateTableAsync<Note>().Wait();

        }

        public Task<List<Note>> GetNotes()
        {
            return _db.Table<Note>().ToListAsync();
        }

        public Task<Note> GetNoteSingle(int id)
        {
            return _db.Table<Note>().Where(i => i.ID == id)
                            .FirstOrDefaultAsync();
        }

        public Task<int> SaveNote(Note n)
        {
            if (n.ID != 0)
            {
                return _db.UpdateAsync(n);
            }
            else
            {
                return _db.InsertAsync(n);
            }
        }
        public Task<int> DeleteNote(Note n)
        {
            return _db.DeleteAsync(n);

        }
    }
}
