﻿using BUS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace QuanLyCuaHangAnUong
{
    public partial class FrmTrangChu : Form
    {
        private Form currentChildForm;
        private void OpenChildForm(Form childFrom)
        {
            if (currentChildForm != null)
            {
                currentChildForm.Close();
            }
            currentChildForm = childFrom;
            childFrom.TopLevel = false;
            childFrom.FormBorderStyle = FormBorderStyle.None;
            childFrom.Dock = DockStyle.Fill;
            panelDesktop.Controls.Add(childFrom);
            panelDesktop.Tag = childFrom;

            childFrom.BringToFront();
            childFrom.Show();

        }
        public FrmTrangChu(string TenDN)
        {
            InitializeComponent();
            lbtenDN.Text = NhanVien_BUS.layTenNV(TenDN);
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void btnMenu_Click(object sender, EventArgs e)
        {
            OpenChildForm(new FrmMenu());
        }

        private void btnTable_Click(object sender, EventArgs e)
        {
            
            OpenChildForm(new FrmMonAn());
        }

        private void btnStaff_Click(object sender, EventArgs e)
        {
            OpenChildForm(new FrmStaffs());
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {

        }
    }
}
