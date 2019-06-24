
-- No use index
select /*+ FULL(tbl_board) */ * from tbl_board order by bno desc;

-- Instead of 'order by bno desc'
select /*+ INDEX_DESC (tbl_board pk_board) */ * from tbl_board;

-- Instead of 'order by bno asc'
select /*+ INDEX_ASC(tbl_board pk_board) */ * from tbl_board where bno > 0;

-- Show 2 page of bulletin board
select rownum, rn, bno, title 
from (
  select /*+ INDEX_DESC(tbl_board pk_board) */ rownum rn, bno, title, content 
  from tbl_board 
  where rownum <= 20
)
where rn >= 11;
