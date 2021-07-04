package com.hovietlong.tonghopbaivenha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Player_Main extends AppCompatActivity {
    //Khai bao view
    ImageView ivAvatar;
    TextView tvName, tvGoal, tvCountry;
    ListView lvPlayer;
    ArrayList<Player> data = new ArrayList<>();
    Player player;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player__main);
        setControl();
        khoiTao();
        setEvent();
        Log.d("longlog", "onCreate: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            player = data.get(bundle.getInt("index", 0));
            int goal = Integer.parseInt(bundle.getString("Goal", "0"));
            player.setGoal(goal);
            player.setCountry(bundle.getString("Country", ""));
        }
        setEvent();
    }

    private void khoiTao() {
        Player player1 = new Player(R.drawable.xuantruong, "Lương Xuân Trường", 90, "VN");
        Player player2 = new Player(R.drawable.tuananh, "Tuấn Anh", 70, "VN");
        Player player3 = new Player(R.drawable.hungdung, "Hùng Dũng", 43, "VN");
        Player player4 = new Player(R.drawable.vanquyet, "Văn Quyết", 79, "VN");
        data.add(player1);
        data.add(player2);
        data.add(player3);
        data.add(player4);
    }

    private void setEvent() {
        playerAdapter adapter = new playerAdapter(this, R.layout.player_item, data);
        lvPlayer.setAdapter(adapter);
        Intent intent = new Intent();
        intent.setClass(this, Edit_Player.class);
        Bundle bundle = new Bundle();
        lvPlayer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                player = data.get(position);
                bundle.putInt("Avatar", player.getAvatar());
                bundle.putString("Name", player.getName());
                bundle.putInt("Goal", player.getGoal());
                bundle.putString("Country", player.getCountry());
                bundle.putInt("index", position);
                intent.putExtras(bundle);
                startActivity(intent);
                Log.d("longlog", "get position: " + index);
            }
        });
        lvPlayer.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(Player_Main.this);
                //Thiết lập tiêu đề
                b.setTitle("DELETE PLAYER");
                b.setMessage("Are you sure to delete this player?");
                // Nút Ok
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        player = data.get(position);
                        data.remove(player);
                        adapter.notifyDataSetChanged();
                    }
                });
                //Nút Cancel
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                //Tạo dialog,
                AlertDialog al = b.create();
                //Hiển thị
                al.show();
                return true;
            }
        });
    }

    private void setControl() {
        ivAvatar = findViewById(R.id.ivAvatar);
        tvName = findViewById(R.id.tvName);
        tvGoal = findViewById(R.id.tvGoal);
        tvCountry = findViewById(R.id.tvCountry);
        lvPlayer = findViewById(R.id.lvPlayer);
    }
}