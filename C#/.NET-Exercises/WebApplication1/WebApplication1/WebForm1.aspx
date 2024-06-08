<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebApplication1.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>sos</title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style2 {
            width: 195px;
            height: 130px;
        }
        .auto-style4 {
            width: 87px;
            height: 130px;
        }
        .auto-style5 {
            width: 1920px;
            height: 1080px;
        }
        .auto-style6 {
            width: 419px;
        }
        .auto-style7 {
            width: 419px;
            height: 187px;
        }
        .auto-style8 {
            height: 187px;
        }
    </style>
</head>
<body style="background-color: blue;">
    <form id="form1" runat="server">
        <div style="background-color: #FF0000; color: #FFFFFF;">
            this is a test site</div>
               
            <br />

            <asp:Button ID="Button1" runat="server" Text="Button" OnClick="Button1_Click" />
       
            <table class="auto-style1">
                <tr>
                    <td class="auto-style6">
                        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
                    </td>
                    <td>
                        <img alt="dice" class="auto-style2" src="images/dice.jpg" /></td>
                </tr>
                <tr>
                    <td class="auto-style6">
                        <asp:TextBox ID="TextBox1" runat="server" OnTextChanged="TextBox1_TextChanged"></asp:TextBox>
                    </td>
                    <td>
                        <img alt="city" class="auto-style5" src="images/street_city_sunset_160055_1920x1080.jpg" /></td>
                </tr>
                <tr>
                    <td class="auto-style7">
                        <asp:Label ID="Label2" runat="server" Text="Label"></asp:Label>
                    </td>
                    <td class="auto-style8">
                        <img alt="tree" class="auto-style4" src="images/tree.jpg" /></td>
                </tr>
            </table>
        </p>
    </form>
</body>
</html>
