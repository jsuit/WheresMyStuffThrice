package com.example.wheresmystuff.Model.Item;

public interface Item {

	/**
	 * Set item's name
	 * 
	 * @param String
	 *            newItemName
	 */

	public void setItemName(String newItemName);

	/**
	 * Set item's Category
	 * 
	 * @param String
	 *            newItemCategory
	 */

	public void setItemCategory(String newItemCategory);

	/**
	 * Set item's status to open or closed
	 * 
	 * @param String
	 *            newItemStatus
	 */

	public void setItemStatus(String newItemStatus);

	/**
	 * Set item's Description
	 * 
	 * @param String
	 *            newItemDescription
	 */
	public void setItemDescription(String newItemDescription);

	/**
	 * Returns item's name
	 * 
	 * @return String
	 * 
	 */

	public String getItemName();

	/**
	 * Get item's Category
	 * 
	 * @return String
	 * 
	 */
	public String getItemCategory();

	/**
	 * Get item's status (open or closed)
	 * 
	 * @return String
	 * 
	 */

	public String getItemStatus();

	/**
	 * Get item's Description
	 * 
	 * @return String
	 * 
	 */

	public String getItemDescription();

	/**
	 * Get item's Street value (where it was found)
	 * 
	 * @return String
	 * 
	 */
	public String getStreet();

	/**
	 * Get item's zip_code
	 * 
	 * @return String
	 * 
	 */
	public String getZip();

	/**
	 * Returns an array of ints that tell us whether we have a heirloom, misc,
	 * and/or keepsake. For more info see ItemInfo kindofItem()
	 * 
	 * 
	 * @return String
	 * 
	 */
	public int[] kindofItem();

	/**
	 * Get Date Item was found
	 * 
	 * @return Long
	 * 
	 */

	public Long getDateAsString();

}
